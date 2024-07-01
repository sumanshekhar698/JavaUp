package com.codecounty.java.advance.multithreading.multithreading_by_defog.threadlocal;

import com.codecounty.java.advance.multithreading.multithreading_by_defog.parallelism.User;

public class WebServiceOptimized {


}

class UserContextHolder {
    public static ThreadLocal<User> holder = new ThreadLocal<User>();

}


class Service1 {//Set it for current thread

    private void process() {
        User user = getUser();
        //set
        UserContextHolder.holder.set(user);
    }

    private User getUser() {
        return new User(1, 8998);
    }
}

class Service2 {
    private void process() {
        //get
        User user = UserContextHolder.holder.get();//Get it for current Thread
    }
}

class Service3 {
    private void process() {
        //get
        User user = UserContextHolder.holder.get();
    }
}

class Service4 {
    private void process() {
        //get
        User user = UserContextHolder.holder.get();
        //cleanup
        UserContextHolder.holder.remove();
    }
}