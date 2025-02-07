package com.finalproject.Service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.finalproject.Entity.Group;
import org.springframework.stereotype.Service;
import com.finalproject.Entity.User;
import com.finalproject.Repo.GroupRepository;
import com.finalproject.Repo.UserRepository;
@Service
public class GroupService {
    @Autowired
    public GroupRepository groupRepository;

    @Autowired
    public UserRepository userRepository;

    public Group createGroup(String name, List<Integer> memberIds) {
    	Group group = new Group();
        group.setName(name);
        List<User> members = userRepository.findAllById(memberIds);
        group.setMembers(new HashSet<>(members));
        return groupRepository.save(group);
    }

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public void deleteGroup(Integer id) {
        groupRepository.deleteById(id);
    }
}