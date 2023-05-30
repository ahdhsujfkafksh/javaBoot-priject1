package com.example.javabootpriject1.po;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="t_table")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickName;
    private String email;
    //评论内容
    private String content;
    //头像
    private String avatar;
    //评论时间
    //`@Temporal` 注解用于指定时间属性的精度，例如 `TIMESTAMP` 精度表示时间戳精度，即精确到秒和毫秒级别。
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @ManyToOne
    private Blog blog;

    //`@OneToMany` 注解用于标注 `replyComments` 属性，表示一个评论实体可以拥有多个回复评论实体。由于 `replyComments` 属性是一个列表，因此这个关系是一对多的关系。
    @OneToMany(mappedBy = "parentComment")
    private List<Comment> replyComments= new ArrayList<>();

    //`@ManyToOne` 注解用于标注 `parentComment` 属性，表示一个回复评论实体只属于一个评论实体。由于一个评论实体可以有多个回复评论实体，因此这个关系是多对一的关系。
    @ManyToOne
    private Comment parentComment;

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public List<Comment> getReplyComments() {
        return replyComments;
    }

    public void setReplyComments(List<Comment> replyComments) {
        this.replyComments = replyComments;
    }

    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                ", avatar='" + avatar + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
