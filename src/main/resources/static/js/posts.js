/**
 * Created by renecortez on 6/27/17.
 */

(function($) {
    request = $.ajax({
        'url': '/post.json'
    });
    request.done(function (posts) {
        var html = '';
        posts.forEach(function(post) {
            html += '<div>';
            html += '<h1>' + post.title + '</h1>';
            html += '<p>' + post.body + '</p>';
            html += '<p>Published by ' + post.owner.username + '</p>';
            html += '</div>';
        });
        $('#posts').html(html);
    });
})(jQuery);
