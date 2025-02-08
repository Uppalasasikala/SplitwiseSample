package com.finalproject.DtoTest;

import com.finalproject.dto.GroupRequest;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class GroupRequestTest {

    @Test
    public void testNoArgsConstructor() {
        GroupRequest groupRequest = new GroupRequest();
        assertNotNull(groupRequest);
    }

    @Test
    public void testAllArgsConstructor() {
        List<Integer> memberIds = Arrays.asList(1, 2, 3);
        GroupRequest groupRequest = new GroupRequest("GroupName", memberIds);
        assertEquals("GroupName", groupRequest.getName());
        assertEquals(memberIds, groupRequest.getMemberIds());
    }

    @Test
    public void testSettersAndGetters() {
        GroupRequest groupRequest = new GroupRequest();
        groupRequest.setName("GroupName");
        List<Integer> memberIds = Arrays.asList(1, 2, 3);
        groupRequest.setMemberIds(memberIds);

        assertEquals("GroupName", groupRequest.getName());
        assertEquals(memberIds, groupRequest.getMemberIds());
    }

}