package com.ll.domain.wiseSaying.controller

import com.ll.TestRunner
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import kotlin.test.Test

class WiseSayingControllerTest {
    @Test
    @DisplayName("등록")
    fun t1() {
        val result = TestRunner.run(
            """
            등록
            현재를 사랑하라.
            작자미상
        """
        )


        assertThat(result).contains("명언 : ")
        assertThat(result).contains("작가 : ")
        assertThat(result).contains("1번 명언이 등록되었습니다.")
    }

    @Test
    @DisplayName("목록 조회")
    fun t2() {
        val result = TestRunner.run(
            """
            등록
            현재를 사랑하라.
            작자미상
            등록
            과거에 집착하지 마라.
            unknown
            목록
        """
        )

        assertThat(result).contains("1 / 작자미상 / 현재를 사랑하라.")
        assertThat(result).contains("2 / unknown / 과거에 집착하지 마라.")
    }

    @Test
    @DisplayName("삭제")
    fun t3() {
        val result = TestRunner.run(
            """
            등록
            현재를 사랑하라.
            작자미상
            등록
            과거에 집착하지 마라.
            unknown
            삭제?id=1
            목록
        """
        )

        assertThat(result).contains("1번 명언을 삭제하였습니다.")
        assertThat(result).doesNotContain("1 / 작자미상 / 현재를 사랑하라.")
        assertThat(result).contains("2 / unknown / 과거에 집착하지 마라.")
    }

    @Test
    @DisplayName("수정")
    fun t4() {
        val result = TestRunner.run(
            """
            등록
            현재를 사랑하라.
            작자미상
            수정?id=1
            현재를 사랑하라. 과거에 집착하지 마라.
            unknown
            목록
        """
        )

        assertThat(result).contains("1번 명언을 수정하였습니다.")
        assertThat(result).doesNotContain("1 / 작자미상 / 현재를 사랑하라.")
        assertThat(result).contains("1 / unknown / 현재를 사랑하라. 과거에 집착하지 마라.")
    }
}