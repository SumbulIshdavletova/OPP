package opp

import org.junit.Assert.*
import org.junit.Test

class WallServiceTest {

    @Test
    fun addCommitted() {
        var id = 0
        val post = WallService.add(
            Post(
                id = ++id,
                ownerId = 0,
                fromId = 0,
                createdBy = 0,
                date = 2300,
                text = "content",
                replyOwnerId = 0,
                replyPostId = 0,
                friendsOnly = false,
                postType = "type",
                signerId = 1,
                canPin = false,
                canDelete = false,
                canEdit = true,
                isPinned = false,
                markedAsAds = false,
                isFavorite = false,
                postponedId = 1
            )
        )
        val result = post.id != 0
        assertEquals(true, result)
    }

    @Test
    fun updateTrue() {
        val result = WallService.update(
            Post(
                id = 1,
                ownerId = 1,
                fromId = 1,
                createdBy = 0,
                date = 2300,
                text = "content",
                replyOwnerId = 0,
                replyPostId = 0,
                friendsOnly = false,
                postType = "type",
                signerId = 1,
                canPin = false,
                canDelete = false,
                canEdit = true,
                isPinned = false,
                markedAsAds = false,
                isFavorite = false,
                postponedId = 1
            )
        )
        assertTrue(result)
    }


    @Test
    fun updateFalse() {
        val result = WallService.update(
            Post(
                id = 0,
                ownerId = 1,
                fromId = 1,
                createdBy = 0,
                date = 2300,
                text = "content",
                replyOwnerId = 0,
                replyPostId = 0,
                friendsOnly = false,
                postType = "type",
                signerId = 1,
                canPin = false,
                canDelete = false,
                canEdit = true,
                isPinned = false,
                markedAsAds = false,
                isFavorite = false,
                postponedId = 1
            )
        )
        assertFalse(result)
    }
}


