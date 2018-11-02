function f(){
    class Post {
        constructor(title,content) {
            this.title=title;
            this.content=content;
        }


        toString(){
            return `Post: ${this.title}\nContent: ${this.content}`
        }
    }

    class SocialMediaPost extends Post{
        constructor(title,content,likes,dislikes) {
            super(title,content);
            this.likes=likes;
            this.dislikes=dislikes;
            this.comments=[];
        }

        addComment(comment){
            this.comments.push(comment);
        }

        toString(){
            if(this.comments.length>=1){
                let res = [];
                for (let i = 0; i < this.comments.length; i++) {
                    res.push("\n * "+this.comments[i])
                }
                return `${super.toString()}\nRating: ${this.likes-this.dislikes}\nComments:${res.join("")}`;
            }else{
                return `${super.toString()}\nRating: ${this.likes-this.dislikes}`;
            }
        }
    }

    class BlogPost extends Post{
        constructor(title,content,views) {
            super(title,content);
            this.views=views;
        }

        view(){
            this.views++;
            return this.views;
        }

        toString(){
            return `${super.toString()}\nViews: ${this.views}`;
        }
    }

    return {Post,SocialMediaPost,BlogPost}
}

let s = new SocialMediaPost("Java Programming Language","Java is more than just cup of coffe",5,3);
s.addComment("Nice post!");

let post = new Post("Post", "Content");

console.log(post.toString());

// Post: Post
// Content: Content

let scm = new SocialMediaPost("TestTitle", "TestContent", 25, 30);

scm.addComment("Good post");
scm.addComment("Very good post");
scm.addComment("Wow!");

console.log(scm.toString());

// Post: TestTitle
// Content: TestContent
// Rating: -5
// Comments:
//  * Good post
//  * Very good post
//  * Wow!


