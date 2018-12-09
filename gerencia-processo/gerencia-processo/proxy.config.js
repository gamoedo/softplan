const proxy = [
    {
      context: '/rest',
      target: 'http://localhost:8080',
      pathRewrite: {'^/api' : '/rest'}
    }
  ];
  module.exports = proxy;