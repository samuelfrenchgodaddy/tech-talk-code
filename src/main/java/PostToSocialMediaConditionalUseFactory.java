import PostToSocialMediaObjects.IndividualHandlers.*;
import PostToSocialMediaObjects.*;

/**
 * THIS CLASS IS RESPONSIBLE FOR INVOKING FACTORY AND POSTING CONTENT, IT WILL NOT NEED TO BE CHANGED TO ADD NEW SOCIAL MEDIA TYPES
 */
public class PostToSocialMediaConditionalUseFactory implements PostToSocialMedia {

    public String postToSocialMedia(String socialMediaType, String content) {
        //IMAGINE THIS IS MORE COMPLEX LOGIC, WE WOULD ONLY NEED TO PROGRAM ONCE TO THE SocialMediaPostHandler interface, then this code will not need to be changed again
        return SocialMediaPostHandlerFactory.getHandler(socialMediaType).post(content);
    }
}
