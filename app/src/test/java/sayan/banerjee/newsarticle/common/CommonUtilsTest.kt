package sayan.banerjee.newsarticle.common

import org.junit.Assert.*
import org.junit.Test

class CommonUtilsTest {
    @Test
    fun getFeedBaseURLTest() {
        assertEquals(APIConstants.FEED_BASE_URL, CommonUtils.getFeedBaseURL())
        assertNotEquals("123", CommonUtils.getFeedBaseURL())
    }
}