package com.ll.domian.wiseSaying.service

import com.ll.domain.wiseSaying.repository.WiseSayingFileRepository
import com.ll.domian.wiseSaying.entity.WiseSaying
import com.ll.standard.dto.Page

class WiseSayingService {
    private val wiseSayingRepository = WiseSayingFileRepository()

    fun write(content: String, author: String): WiseSaying {
        return wiseSayingRepository.save(WiseSaying(content, author))
    }

    fun isEmpty(): Boolean {
        return wiseSayingRepository.isEmpty()
    }

    fun findAll(): List<WiseSaying> {
        return wiseSayingRepository.findAll()
    }

    fun findById(id: Int): WiseSaying? {
        return wiseSayingRepository.findById(id)
    }

    fun findAllPaged(itemsPerPage: Int, pageNo: Int): Page<WiseSaying> {
        return wiseSayingRepository.findAllPaged(itemsPerPage, pageNo)
    }

    fun findByKeywordPaged(keywordType: String, keyword: String, itemsPerPage: Int, pageNo: Int): Page<WiseSaying> {
        return wiseSayingRepository.findByKeywordPaged(keywordType, keyword, itemsPerPage, pageNo)
    }

    fun delete(wiseSaying: WiseSaying) {
        return wiseSayingRepository.delete(wiseSaying)
    }

    fun modify(wiseSaying: WiseSaying, content: String, author: String) {
        wiseSaying.modify(content, author)
        wiseSayingRepository.save(wiseSaying)
    }

    fun build() {
        wiseSayingRepository.build()
    }
}