package opp

data class Post(
    val id: Int,
    val ownerId: Int,
    val fromId: Int?,
    val createdBy: Int,
    val date: Int,
    val text: String,
    val replyOwnerId: Int?,
    val replyPostId: Int,
    val friendsOnly: Boolean,
    val postType: String,
    val signerId: Int,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean?,
    val isPinned: Boolean,
    val markedAsAds: Boolean,
    val isFavorite: Boolean,
    val postponedId: Int,
    val attachment: Array<Attachment> = emptyArray()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Post

        if (id != other.id) return false
        if (ownerId != other.ownerId) return false
        if (fromId != other.fromId) return false
        if (createdBy != other.createdBy) return false
        if (date != other.date) return false
        if (text != other.text) return false
        if (replyOwnerId != other.replyOwnerId) return false
        if (replyPostId != other.replyPostId) return false
        if (friendsOnly != other.friendsOnly) return false
        if (postType != other.postType) return false
        if (signerId != other.signerId) return false
        if (canPin != other.canPin) return false
        if (canDelete != other.canDelete) return false
        if (canEdit != other.canEdit) return false
        if (isPinned != other.isPinned) return false
        if (markedAsAds != other.markedAsAds) return false
        if (isFavorite != other.isFavorite) return false
        if (postponedId != other.postponedId) return false
        if (!attachment.contentEquals(other.attachment)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + ownerId
        result = 31 * result + (fromId ?: 0)
        result = 31 * result + createdBy
        result = 31 * result + date
        result = 31 * result + text.hashCode()
        result = 31 * result + (replyOwnerId ?: 0)
        result = 31 * result + replyPostId
        result = 31 * result + friendsOnly.hashCode()
        result = 31 * result + postType.hashCode()
        result = 31 * result + signerId
        result = 31 * result + canPin.hashCode()
        result = 31 * result + canDelete.hashCode()
        result = 31 * result + (canEdit?.hashCode() ?: 0)
        result = 31 * result + isPinned.hashCode()
        result = 31 * result + markedAsAds.hashCode()
        result = 31 * result + isFavorite.hashCode()
        result = 31 * result + postponedId
        result = 31 * result + attachment.contentHashCode()
        return result
    }
}

abstract class Attachment(val type: String)

open class AudioAttachment(val audio: Audio) : Attachment("audio")
class Audio() : AudioAttachment(Audio())
open class VideoAttachment(val video: Video) : Attachment("video")
class Video() : VideoAttachment(Video())
open class PhotoAttachment(val photo: Photo) : Attachment("photo")
class Photo() : PhotoAttachment(Photo())
open class DocAttachment(val doc: Doc) : Attachment("doc")
class Doc() : DocAttachment(Doc())
open class LinkAttachment(val link: Link) : Attachment("link")
class Link() : LinkAttachment(Link())

class PostNotFoundException : RuntimeException()

data class Comment(
    val id: Int,
    val fromId: Int,
    val date: Int,
    val text: String
)

data class Report(
    val ownerId: Int,
    val commentId: Int,
    val reason: Int
)

class ReportCommentNotFoundException : RuntimeException()
class ReportReasonNotFoundException : RuntimeException()

object WallService {
    private var posts = emptyArray<Post>()

    private var id = 0

    fun add(post: Post): Post {
        posts += post.copy(id = ++id)
        return posts.last()
    }

    private var comments = emptyArray<Comment>()

    @Throws(PostNotFoundException::class)
    fun createComment(postId: Int, comment: Comment): Comment {
        var post = posts.last()
        if (postId == post.id) {
            comments += comment.copy(0, 0, 100, "comment")
            return comments.last()
        }
        throw PostNotFoundException()
    }

    var reports = emptyArray<Report>()

    @Throws(ReportCommentNotFoundException::class, ReportReasonNotFoundException::class)
    fun reportComment(report: Report, ownerId: Int): Boolean {
        if (ownerId == report.ownerId) {
            if (report.reason <= 8) {
                reports += report
                return true
            }
            throw ReportReasonNotFoundException()
        }
        throw ReportCommentNotFoundException()
    }


    fun update(post: Post): Boolean {
        for ((index, postArray) in posts.withIndex()) {
            if (post.id == id) {
                posts[index] = postArray.copy(
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