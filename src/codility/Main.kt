package codility

import java.security.InvalidKeyException

fun solution(A: IntArray): Int {
    // write your code in Kotlin 1.3.11 (Linux)

    if (A.size < 3) return -1

    val sorted = A.sorted()

    var boundaryIndex = -1
    for (i in 0 until sorted.size) {
        if (sorted[i] >= 0) {
            boundaryIndex = i
            break
        }
    }

    val hasZero = if (boundaryIndex == -1) false else sorted[boundaryIndex] == 0
    val minusNums = if (boundaryIndex == -1) sorted else sorted.slice(0 until boundaryIndex)
    val plusNums =
        if (boundaryIndex == -1)
            mutableListOf<Int>()
        else if (hasZero)
            sorted.slice(boundaryIndex + 1 until sorted.size)
        else
            sorted.slice(boundaryIndex until sorted.size)

    val candidate = mutableListOf<Int>()

    if (hasZero) candidate.add(0)

    if (plusNums.any()) {
        if (plusNums.count() >= 3)
            candidate.add(
                plusNums[plusNums.count() - 1] * plusNums[plusNums.count() - 2] * plusNums[plusNums.count() - 3]
            )

        if (minusNums.count() >= 2)
            candidate.add(
                plusNums[plusNums.count() - 1] * minusNums[0] * minusNums[1]
            )
    }

    if (minusNums.count() >= 3)
        candidate.add(
            minusNums[minusNums.count() - 1] * minusNums[minusNums.count() - 2] * minusNums[minusNums.count() - 3]
        )

    System.err.println("${boundaryIndex} sorted:${sorted} candidates:${candidate}")
    System.err.println("hasZero: ${hasZero} plus:${plusNums} minus:${minusNums}")

    var max = Int.MIN_VALUE
    for (c in candidate)
        if (c > max) max = c

    return max
}
