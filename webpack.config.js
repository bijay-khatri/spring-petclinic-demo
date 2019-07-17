const path = require('path');

module.exports = {
    entry: './src/main/javascript/index.js',
    output: {
        filename: 'bundle.js',
        path: path.resolve(__dirname, 'src/main/resources/static/dist')
    },
    mode: 'development',
    devtool: "source-map",
    resolve: {
        extensions: [".js", ".jsx"]
    },
    module: {
        rules: [
            {
                test: /\.(js|jsx)$/,
                exclude: /node_modules/,
                use: {
                    loader: "babel-loader"
                }
            },
            {
                test: /\.css$/i,
                use: ['style-loader', 'css-loader'],
            }
        ]
    }

};
