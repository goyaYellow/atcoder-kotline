package lib

import java.util.*

// 約数のList
fun divisor(value: Long): List<Long> {
    val max = Math.sqrt(value.toDouble()).toLong()
    return (1..max)
        .filter { value % it == 0L }
        .map { listOf(it, value / it) }
        .flatten()
        .sorted()
}

// 範囲内の素数を取得
// fromだけ指定すると戻り値の個数で素数判定ができる
fun prime(from: Long, to: Long = from): List<Long> {
    return (from..to).filter { i ->
        val max = Math.sqrt(i.toDouble()).toLong()
        (2..max).all { j -> i % j != 0L }
    }
}

// 渡された値が素数か判定
fun isPrime(source: Int): Boolean {
    return prime(source.toLong()).any()
}

// 素因数分解
fun decom(value: Long): List<Long> {
    if (value == 1L) return listOf(1)
    val max = Math.sqrt(value.toDouble()).toLong()
    return prime(2, max).filter { value % it == 0L }
}

// 最大公約数
fun gcd(a: Long, b: Long): Long {
    return if (a % b == 0L) b else gcd(b, a % b)
}

// 文字列を入れ替え
fun swap(base: String, a: String, b: String): String {
    return base.map {
        when (it) {
            a.toCharArray()[0] -> b
            b.toCharArray()[0] -> a
            else -> it.toString()
        }
    }.joinToString()
}

/**
 * リストをスタックに変換する
 * @param list リスト
 * @return スタック
 */
fun listToStack(list: List<Int>): Stack<Int> {
    // スタック
    val stack = Stack<Int>()

    for (e in list) {
        stack.push(e)
    }

    return stack
}

/**
 * ユークリッドの互除法を用いて、最大公約数を導出する
 * @param list 最大公約数を求める対象となる数が格納されたリスト
 * @return 最大公約数
 */
fun gcd(list: List<Int>): Int {
    // 最大公約数を求める対象となる数が格納されたスタック
    val stack = listToStack(list)

    // ユークリッドの互除法を用いて、最大公約数を導出する
    // (最終的にスタック内に1つだけ数が残り、それが最大公約数となる)
    while (1 < stack.size) {
        // スタックから2つの数をpop
        val pops = (0 until 2).map {
            stack.pop()
        }

        // スタックからpopした2つの数のうち、小さい方の数のインデックス
        val minIndex = if (pops[1] < pops[0]) {
            1
        } else {
            0
        }

        // スタックからpopした2つの数のうち、小さい方の数をpush
        stack.push(pops[minIndex])

        // スタックからpopした2つの数の剰余
        val r = pops[(minIndex + 1) % 2] % pops[minIndex]

        // スタックからpopした2つの数に剰余があるならば、それをpush
        if (0 < r) {
            stack.push(r)
        }
    }

    // 最大公約数を返す
    return stack.pop()
}

/**
 * 最小公倍数を導出する
 * @param list 最小公倍数を求める対象となる数が格納されたリスト
 * @return 最小公倍数
 */
fun lcm(list: List<Int>): Int {
    // 最大公約数を求める対象となる数が格納されたスタック
    val stack = listToStack(list)

    // 最小公倍数を導出する
    // (最終的にスタック内に1つだけ数が残り、それが最小公倍数となる)
    while (1 < stack.size) {
        // スタックから2つの数をpop
        val pops = (0 until 2).map {
            stack.pop()
        }

        // スタックからpopした2つの数の最小公倍数をpush
        stack.push(pops[0] * pops[1] / gcd(pops))
    }

    // 最小公倍数を返す
    return stack.pop()
}