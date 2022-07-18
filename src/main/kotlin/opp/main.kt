package opp

data class Post(
    val id: Int,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val date: Int,
    val text: String,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendsOnly: Boolean,
    val postType: String,
    val signerId: Int,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean,
    val markedAsAds: Boolean,
    val isFavorite: Boolean,
    val postponedId: Int
)


object WallService {
    var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        posts += Post(
            id = 1,
            ownerId = 1,
            fromId = 1,
            createdBy = 1,
            date = 2000,
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
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((id, post) in posts.withIndex()) {
            if (post.id == id) {
                posts[id] = post.copy(
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
                return true
            }
        }
        return false
    }
}


fun main() {

}