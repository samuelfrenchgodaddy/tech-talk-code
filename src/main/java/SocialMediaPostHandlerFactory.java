import PostToSocialMediaObjects.*;
import PostToSocialMediaObjects.IndividualHandlers.*;

import java.util.*;

/**
 * THIS CLASS IS RESPONSIBLE FOR PROVIDING SOCIAL MEDIA HANDLER FOR GIVEN TYPE
 */
public class SocialMediaPostHandlerFactory {

    private static final Map<String, SocialMediaPostHandler> handlerLibrary;
    static {
        Map<String, SocialMediaPostHandler> tempMap = new HashMap<>();
        tempMap.put("facebook", new FacebookHandler());
        tempMap.put("instagram", new InstagramHandler());
        tempMap.put("twitter", new TwitterHandler());
        handlerLibrary = Collections.unmodifiableMap(tempMap);
    }

    public static SocialMediaPostHandler getHandler(String socialMediaType){
        if(handlerLibrary.get(socialMediaType) == null){
            throw new UnsupportedOperationException();
        }
        return handlerLibrary.get(socialMediaType);
    }
}
