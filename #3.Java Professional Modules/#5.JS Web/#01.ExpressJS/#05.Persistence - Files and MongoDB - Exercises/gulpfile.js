const Gulpfile = require('gulp');
const MinifyCss = require('gulp-clean-css');
const Rename = require('gulp-rename');

Gulpfile.task('minify-css',()=>{
    Gulpfile.src('resources/*.css')
        .pipe(MinifyCss())
        .pipe(Rename({
            suffix: '.min'
        }))
        .pipe(Gulpfile.dest('content'));
});