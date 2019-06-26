package com.example.blog.commons

import java.time.LocalDateTime
import java.time.format.DateTimeFormatterBuilder
import java.time.temporal.ChronoField
import java.util.*
import java.util.regex.Pattern

fun LocalDateTime.format() = this.format(englishDateFormatter)

private val daysLookup = (1..31).associate { it.toLong() to getOrdinal(it) }

private val englishDateFormatter = DateTimeFormatterBuilder()
		.appendPattern("yyyy-MM-dd")
		.appendLiteral(" ")
		.appendText(ChronoField.DAY_OF_MONTH, daysLookup)
		.appendLiteral(" ")
		.appendPattern("yyyy")
		.toFormatter(Locale.ENGLISH)

private fun getOrdinal(n: Int) = when {
	n in 11..13 -> "${n}th"
	n % 10 == 1 -> "${n}st"
	n % 10 == 2 -> "${n}nd"
	n % 10 == 3 -> "${n}rd"
	else -> "${n}th"
}

fun String.toSlug() = toLowerCase()
		.replace("\n", " ")
		.replace("[^a-z\\d\\s]".toRegex(), " ")
		.split(" ")
		.joinToString("-")
		.replace("-+".toRegex(), "-")


fun findLastNo(string:String): Int {
	var result = ""
	var regEx = "\\d+"
	var pattern = Pattern.compile(regEx)
	var matcher = pattern.matcher(string)
	while (matcher.find()) {
		for (j in 0..matcher.groupCount()) {
			result = matcher.group(j)
		}
	}
	return Integer.parseInt(result)
}


