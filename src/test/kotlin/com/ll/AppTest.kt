package com.ll

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import kotlin.test.Test

class AppTest {

    @Test
    @DisplayName("명언 작성")
    fun t1() {
        val result = TestRunner.run(
            """
            등록
            나의 죽음을 적들에게 알리지 말라.
            충무공 이순신
        """
        )
        println("result: $result")

        assertThat(result).contains("명언")
        assertThat(result).contains("작가")
        assertThat(result).contains("1번 명언이 등록되었습니다.")
    }
}