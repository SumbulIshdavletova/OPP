package opp

import org.junit.Assert.*
import org.junit.Test

class WallServiceTest {

    @Test
    fun addCommitted() {
        val service = WallService()
        var id = 0
        val post = service.add(
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

        val service = WallService()
        service.add(
            Post(
                id = 1,
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

        val result = service.update(
            Post(
                id = 1,
                ownerId = 0,
                fromId = 1,
                createdBy = 0,
                date = 2300,
                text = "content2",
                replyOwnerId = 0,
                replyPostId = 0,
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
        )
        assertTrue(result)
    }


    @Test
    fun updateFalse() {
        val service = WallService()
        service.add(
            Post(
                id = 1,
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

        val result = service.update(
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

    @Test
    fun commentCreated() {
        val service = WallService()
        service.add(
            Post(
                id = 1,
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
        service.createComment(1, Comment(0, 2, 345, "comment"))
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        val service = WallService()
        service.add(
            Post(
                id = 1,
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

        service.createComment(4, Comment(3, 2, 345, "comment"))
    }

    @Test(expected = ReportCommentNotFoundException::class)
    fun reportCommentOwnerId() {

        val service = WallService()
        service.reportComment(Report(2, 2, 2), 1)
    }

    @Test(expected = ReportReasonNotFoundException::class)
    fun reportCommentReason() {

        val service = WallService()
        service.reportComment(Report(1, 2, 9), 1)
    }

}


