package com.finalproject.dto;

import java.util.List;

public class GroupRequest {
    public String name;
    public List<Integer> memberIds;

    public GroupRequest() {}

    public GroupRequest(String name, List<Integer> memberIds) {
        this.name = name;
        this.memberIds = memberIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getMemberIds() {
        return memberIds;
    }

    public void setMemberIds(List<Integer> memberIds) {
        this.memberIds = memberIds;
    }

    @Override
    public String toString() {
        return "GroupRequest{name='" + name + "', memberIds=" + memberIds + "}";
    }
}
