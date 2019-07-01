import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostToSocialMediaConditionalTest {

    PostToSocialMedia postToSocialMediaConditional = new PostToSocialMediaConditional();

    @Test
    void postToSocialMedia() {
        assert postToSocialMediaConditional.postToSocialMedia("facebook","abc").equals("workedOKFacebook");
        assert postToSocialMediaConditional.postToSocialMedia("facebook","1234d").equals("workedOKFacebook");

    }
}