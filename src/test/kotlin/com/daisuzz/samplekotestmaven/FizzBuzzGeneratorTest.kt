package com.daisuzz.samplekotestmaven

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

/**
 * いろいろな記法でテストを書くことができる
 *
 * [https://kotest.io/docs/framework/testing-styles.html]
 */
class FizzBuzzGeneratorTest : FunSpec({

    val fizzBuzzGenerator = FizzBuzzGenerator()

    // contextでテストケースをまとめられる
    context("正常系") {

        // listOf().forEach{}でparameterized testingができる
        listOf(1, 2, 4, 7, 8).forEach {

            // test(){}でテストケースを作成する
            test("$it を渡すと$it を返す") {

                // act, assertをここで書く
                fizzBuzzGenerator.generate(it) shouldBe it.toString()
            }
        }

        listOf(3, 6, 9, 12).forEach {
            test("$it を渡すとFizzを返す") {
                fizzBuzzGenerator.generate(it) shouldBe "Fizz"
            }
        }

        listOf(5, 10, 20, 25).forEach {
            test("$it を渡すとBuzzを返す") {
                fizzBuzzGenerator.generate(it) shouldBe "Buzz"
            }
        }

        listOf(15, 30, 45, 60).forEach {
            test("$it を渡すとFizzBuzzを返す") {
                fizzBuzzGenerator.generate(it) shouldBe "FizzBuzz"
            }
        }
    }

    context("異常系") {
        listOf(-1, 0).forEach {
            test("$it を渡すとIllegalArgumentExceptionを投げる") {
                // 例外のassertionはshouldThrow<>を使って書ける
                shouldThrow<IllegalArgumentException> {
                    fizzBuzzGenerator.generate(it)
                }
            }
        }
    }
})
