package opp

import org.junit.Assert.*
import org.junit.Test

class WallServiceTest {

    @Test
    fun addCommitted() {
        val service = WallService
        var posts = emptyArray<Post>()
        val post = service.add(
            Post(
                id = 1,
                ownerId = 1,
                fromId = 1,
                createdBy = 1,
                date = 2300,
                text = "content",
                replyOwnerId = 1,
                replyPostId = 1,
                friendsOnly = false,
                postType = "type",
                signerId = 1,
                canPin = false,
                canDelete = false,
                canEdit = true,
                isPinned = false,
                markedAsAds = false,
                isFavorite = false,
                postponedId = 1,
                attachment = arrayOf(Audio())
            )
        )
        val result = post.id != 0
        assertEquals(true, result)
    }

    @Test
    fun updateTrue() {
        val service = WallService
        var posts = emptyArray<Post>()
        for ((id, post) in WallService.posts.withIndex()) {
            if (post.id == id) {
                WallService.posts[id] = post.copy(
                    ownerId = 1,
                    fromId = 1,
                    createdBy = 1,
                    text = "content2",
                    replyOwnerId = 1,
                    replyPostId = 1,
                    friendsOnly = false,
                    postType = "type2",
                    signerId = 1,
                    canPin = false,
                    canDelete = false,
                    canEdit = true,
                    isPinned = false,
                    markedAsAds = false,
                    isFavorite = false,
                    postponedId = 1
                )
                val result = service.update(post)
                assertTrue(result)
            }
        }
    }


    @Test
    fun updateFalse() {
        val service = WallService

        var posts = emptyArray<Post>()
        for ((id, post) in WallService.posts.withIndex()) {
            if (post.id != id) {
                WallService.posts[id] = post.copy(
                    ownerId = 1,
                    fromId = 1,
                    createdBy = 1,
                    text = "content2",
                    replyOwnerId = 1,
                    replyPostId = 1,
                    friendsOnly = false,
                    postType = "type2",
                    signerId = 1,
                    canPin = false,
                    canDelete = false,
                    canEdit = true,
                    isPinned = false,
                    markedAsAds = false,
                    isFavorite = false,
                    postponedId = 1

                )
            }
            val result = service.update(post)
            assertFalse(result)
        }
    }

}

