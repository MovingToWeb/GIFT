package com.gift.jdbc

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.springframework.context.support.ClassPathXmlApplicationContext

import static com.gift.jdbc.sandbox.SandboxEnvironment.createSandbox

class UserDAOTest {

    def ctx
    enum Tables {
        USER_DETAILS
    }

    @Before
    public void setUp() throws Exception {
        ctx = new ClassPathXmlApplicationContext("test-context.xml");
        createSandbox(Tables)
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void 'should return all user details'() {
        UserDAO dao = new UserDAO(ctx.getBean("jdbcTemplate"));
        List<UserDetails> user = dao.getAllUserDetails();
        assert user == [new UserDetails(userName: 'ajay', userId: 'A001', address: 'Bangalore', country: 'India')]
    }
}
