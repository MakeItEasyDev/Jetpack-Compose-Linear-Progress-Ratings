package com.jetpack.composerating

data class Rating(
    var avg: Float?,
    var description: String?,
    var items: Items?,
    var title: String?
) {
    data class Items(
        var rate1: Int?,
        var rate2: Int?,
        var rate3: Int?,
        var rate4: Int?,
        var rate5: Int?
    ) {
        fun toPairList() = arrayListOf<Pair<String, Int?>>().apply {
            add(Pair("1", rate1))
            add(Pair("2", rate2))
            add(Pair("3", rate3))
            add(Pair("4", rate4))
            add(Pair("5", rate5))
        }
        fun numberOfVotes() = toPairList().sumOf { it.second ?: 0 }.toLong()
    }
}

val items = Rating.Items(
    10,
    6,
    17,
    13,
    10
)

val rating = Rating(
    3.0f,
    "Rating Description",
    items,
    "Rating"
)