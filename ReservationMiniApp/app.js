//app.js
App({
  onLaunch: function () {
    // 展示本地存储能力
    var logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)

    var _ = this
    // 登录
    wx.login({
      success: res => {
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
        console.log(res)

        var codeData = {
          appId: _.globalData.appId,
          secret: _.globalData.secret,
          jsCode: res.code
        }

        console.log(codeData)

        wx.request({
          url: _.globalData.server + "wx-app/login",
          data: codeData,
          method: "POST",
          success: function(e) {
            if (e.data.status == 200) {
              _.globalData.id = e.data.data;
              console.log(_.globalData.id)
            } else {
              wx.showToast({
                title: "登录失败！",
              })
            }
          },
          fail: function(e) {
            wx.showToast({
              title: "登录失败！",
            })
          }
        })
      }
    })

  },
  globalData: {
    userInfo: null,
    server: "http://localhost:8080/",
    appId: "wx08d62bfcf2d36f5f",
    secret: "a1a04e7cd2dfa450aeedf594ae770170",
    id: null,
    phoneNumber: null,
  }
})