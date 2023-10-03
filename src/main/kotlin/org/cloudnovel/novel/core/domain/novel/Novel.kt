package org.cloudnovel.novel.core.domain.novel

import org.cloudnovel.novel.core.domain.novel.comment.Comment

/**
 * 애초에 novel contents, novel comments 이런식으로 나눠서
 * query, command 에 대한 모델이 분리되었다면, 문제 되지 않을 일 아니었을까?
 * */
class Novel(
        id: Long,
        title: String,
        body: String,
        comments: List<Comment>
) {
}