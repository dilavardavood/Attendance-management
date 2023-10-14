package utils;

public interface SQLQueries {

    public interface UserQueries{
        final String CHECK_USER = "select user_id from styria.users where user_id= ?";
        final String GET_USER_COUNT = "SELECT COUNT(*) FROM styria.users WHERE user_id=?";
        final String USER_IS_ACTIVE = "SELECT is_active FROM styria.users WHERE user_id=?";
        final String GET_USER_DETAILS = "SELECT user_id,user_name,role,is_active,added_by,added_on,updated_by,updated_on,deleted_by,deleted_on FROM styria.users WHERE user_id=?";
    }
    public interface ChannelQueries{
        final String GET_ALL_CHANNELS = "select channel_name from styria.channel";
        final String CHECK_CHANNEL = "select * from styria.channel where channel_id= ?";
        final String CHECK_IS_ACTIVE = "SELECT is_active FROM Styria.channel WHERE channel_id = ? ";
        final String FIND_CHANNEL_BY_NAME = "SELECT COUNT(*) FROM styria.channel WHERE channel_name = ?";
        final String INSERT_INTO_CHANNEL = "INSERT INTO styria.Channel (channel_name, channel_descr, created_by, created_on,updated_by,updated_on) VALUES (? , ?, ?, ?, ?, ?)";
        final String UPDATE_SUBSCRIBER_COUNT = "update channel set sub_count = sub_count + 1 where channel_id =?";
        final String GET_CHANNEL_LIST_OF_USER = "select channel_id,channel_name,channel_descr from styria.channel where channel_id in(select channel_id from styria.subscribers where user_id =?)";
        final String UPDATE_CHANNEL = "UPDATE channel SET channel_name = ?, channel_descr = ?, sub_count = ?,access = ?, is_active = ? WHERE channel_id = ?";
        final String GET_ALL_DETAILS = "SELECT * FROM channel WHERE channel_id =?";
        final String DELETE_CHANNEL = "UPDATE Styria.channel SET is_active = 0, deleted_by = ?, deleted_on = current_timestamp() WHERE channel_id = ?";
        final String UPDATE_STATUS = "UPDATE Styria.channel SET is_active = ?, updated_by = ?, updated_on = current_timestamp() WHERE channel_id = ?";



    }
    public interface SubscriberQueries{
        final String CHECK_SUBSCRIPTION_OF_USER = "select channel_id from styria.subscribers where user_id = ?";
        final String ADD_NEW_SUBSCRIBER = "insert into  styria.subscribers (user_id,channel_id,role,added_by,added_on) values (?,?, ?,?,current_timestamp())";

    }
    public interface FeedQueries{
        final String CHECK_FEED = "select feed_id from styria.feed where feed_id= ?";
        final String DELETE_FEED = "delete from styria.feed where feed_id = ?";
        final String GET_FEED_COUNT = "SELECT COUNT(*) FROM styria.feed WHERE feed_id=?";
        final String UPDATE_FEED = "UPDATE styria.feed SET title=? , content=?,updated_by=? ,updated_on=?  WHERE feed_id=?";
        final String GET_FEED_DETAILS = "SELECT feed_id,title,content,channel_id,likes,added_by,added_on,updated_by,updated_on,deleted_by,deleted_on FROM styria.feed WHERE feed_id=?";
    }
    public interface TagsQueries{
        final String ADD_NEW_TAGS = "insert into  styria.tags (feed_id,tag_name,created_by,created_on) values (?,?, ?,current_timestamp()) ";
        final String GET_RECENT_TAGS_OF_USER = "select tags.feed_id , tags.tag_name from styria.tags inner join feed on tags.feed_id=feed.feed_id where feed.feed_id=(select feed.feed_id where feed.channel_id in(select channel_id from subscribers where user_id= ?)) ORDER BY tags.created_on DESC LIMIT 5;";
        final String GET_TRENDING_TAGS = "select feed_id,tag_name from tags where created_on > ( NOW( ) - INTERVAL 24 HOUR) ORDER BY tags.created_on DESC LIMIT ?;";

    }
    public interface AttachmentQueries{
        final String DELETE_ATTACHMENT = "UPDATE attachments SET deleted_on = CURRENT_TIMESTAMP WHERE attachment_id = ? AND feed_id =?;";
        final String CHECK_BEFORE_DELETE = "SELECT COUNT(*) FROM attachments a INNER JOIN Feed f ON a.feed_id = f.feed_id WHERE a.feed_id = ? AND a.attachment_id = ? AND a.deleted_on IS NULL;";
        final String UPDATE_ATTACHMENT = "UPDATE styria.attachments SET type=? , url=?,updated_by=? ,updated_on=?  WHERE attachment_id=?";
        final String CHECK_ATTACHMENT = "SELECT COUNT(*) FROM styria.attachments WHERE attachment_id=?";
        final String ADD_ATTACHMENT = "INSERT INTO Styria.attachments(attachment_id,feed_id,type,url,added_by,added_on) VALUES (?,?,?,?,?,CURRENT_TIMESTAMP)";

    }
    public interface LikesQueries{
        final String DISLIKE_FEED = "UPDATE likes SET deleted_on = CURRENT_TIMESTAMP, deleted_by = ?,status = ? WHERE feed_id = ? AND user_id = ?;";
        final String CHECK_IF_DISLIKED = "SELECT COUNT(*) FROM likes WHERE feed_id = ? AND user_id = ? AND status IS false";
        final String ADD_LIKE_CHECK = "SELECT COUNT(*) FROM styria.likes WHERE user_id=? AND feed_id=?";
        final String ADD_LIKE = "INSERT INTO styria.likes (feed_id, user_id,added_on) VALUES (?, ?,?)";
        final String GET_LIKE = "SELECT U.user_id,U.user_name FROM Styria.feed F\n" +
                "join Styria.likes L on L.feed_id=F.feed_id\n" +
                "join Styria.users U on L.user_id=U.user_id\n" +
                "where F.feed_id = ?;";


    }
    public interface CommentsQueries{
        final String ADD_COMMENTS = "INSERT INTO comments (id,content, feed_id, user_id) VALUES (?,?,?,?)";
        final String COMMENTS_CHECK = "SELECT COUNT(*) FROM styria.comments WHERE id=?";
        final String UPDATE_COMMENT = "UPDATE styria.comments SET content=? ,updated_by=? ,updated_on=? WHERE id=?";
        final String DELETE_COMMENT = "update Styria.comments set deleted_by = ?,deleted_on = current_timestamp() Where id = ?;";
        final String GET_COMMENT = "SELECT id,content,user_id,feed_id,added_on,added_by,updated_on,updated_by,deleted_on,deleted_by FROM styria.comments where feed_id=? and deleted_on IS NULL";
        final String CHECK_SUBSCRIPTION = "SELECT COUNT(*) \n" +
                "FROM subscribers AS s \n" +
                "JOIN channel AS c ON s.channel_id = c.channel_id \n" +
                "JOIN users AS u ON s.user_id = u.user_id \n" +
                "JOIN feed AS f ON c.channel_id = f.channel_id \n" +
                "WHERE f.feed_id = ? AND u.user_id = ?;";
    }
    public interface UserRolesQueries{

    }
    public interface RolesAndPermissionQueries{

    }
}
