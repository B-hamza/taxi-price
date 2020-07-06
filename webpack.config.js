const path = require('path')

module.exports = {
  mode: 'production',
  entry: "./taxi-ride-client/src/main/frontend/src/index.tsx",
  output: {
      filename: "app.js",
      path: path.join(__dirname, "./taxi-ride-client/src/main/resources/public")
  },

  // Enable sourcemaps for debugging webpack's output.
  devtool: "source-map",

  resolve: {
    extensions: [".ts", ".tsx", ".js", ".json"]
  },

  module: {
    rules: [
      // All files with a '.ts' or '.tsx' extension will be handled by 'awesome-typescript-loader'.
      {
        test: /\.tsx?$/,
        loader: "awesome-typescript-loader",
        options: {
          configFileName: path.resolve(__dirname, "tsconfig.json")
        }
      },

      // All output '.js' files will have any sourcemaps re-processed by 'source-map-loader'.
      {
        enforce: "pre",
        test: /\.js$/,
        loader: "source-map-loader"
      },

      {
        test: /\.css$/,
        use: [
          {loader: "style-loader"},
          {loader: "css-loader"}
        ]
      }
    ]
  },
  externals: {
    "react": "React",
    "react-dom": "ReactDOM"
  },
  watchOptions: {
    ignored: /node_modules/
  }
};
