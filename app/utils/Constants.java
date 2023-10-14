package utils;

public interface Constants {

    public interface JSON_KEYS{
        String userId = "userId";
        String limit = "limit";
        String feedId ="feedId";
    }

    public interface ResponseMessages{
        String success = "Success";
        String failure = "Failure";
        String ERR_2 = "Err 2";
        String error = "Error";
        String createChannelError = "Channel creation error";
        String addLikeError = "Add like error";
        String alreadyExists = "already exists";
        String alreadyLiked = "Like operation cannot be performed twice!!";
        String error1004 = "1004";
        String error422 = "422";
        String ok = "200";
        String operationFail = "Operation cannot be performed";
        String notFound = "Not found";
        String databaseAccessFailed = "couldn't access database";
        String invalidUser = "Invalid User";
        String jsonMiss = "Missing field";
        String channelNotExists = "Channel not exists";
        String subscribed = "Already subscribed";
    }
    public interface ResponseCode{

    }
}
