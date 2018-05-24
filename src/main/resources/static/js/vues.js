// 用vue请求文章和评论

var comment = "/comment";
var articlePath = window.location.pathname;
var articleURL = "/" + articlePath.split("/")[1];
var articleId = articlePath.split("/")[2];
var articleApp = new Vue({
    el: "#article",
    data: {
        content: ""
    },
    created: function () {
        var _self = this;
        $.ajax({
            type: "POST",
            url: articleURL,
            data: {
                articleId: articleId
            },
            success: function (data) {
                var md = window.markdownit();
                _self.content = md.render(data);
                commentApp.getComment();
            }
        })
    }
});

var commentApp = new Vue({
    el: "#comment-list",
    data: {
        comments: []
    },
    methods: {
        getComment: function () {
            var _self = this;
            $.ajax({
                type: "GET",
                url: comment + "/" + articleId,
                success: function (data) {
                    _self.comments = data;
                }
            })
        }
    }
});