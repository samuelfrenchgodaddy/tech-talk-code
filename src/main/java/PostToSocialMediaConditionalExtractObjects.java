import PostToSocialMediaObjects.*;
import PostToSocialMediaObjects.IndividualHandlers.*;

/**
 * Woohoo! Now we have all of our logic that is specific to one handler encapsulated into the handler object
 */
public class PostToSocialMediaConditionalExtractObjects implements PostToSocialMedia {

    public String postToSocialMedia(String socialMediaType, String content) {
        SocialMediaPostHandler handler;
        if ("facebook".equals(socialMediaType.toLowerCase())) {
            handler = new FacebookHandler();
        } else if ("instagram".equals(socialMediaType.toLowerCase())) {
            handler = new InstagramHandler();
        } else if ("twitter".equals(socialMediaType.toLowerCase())) {
            handler = new TwitterHandler();
        } else {
            throw new UnsupportedOperationException();
        }
        return handler.post(content);
    }
}
