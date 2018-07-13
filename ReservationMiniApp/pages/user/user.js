var app = getApp()

Page({

  /**
   * 页面的初始数据
   */
  data: {
    hasLogin: false,
    userInfo: null,
    phoneNumber: null
  },

  getUserInfo:function(e) {
    console.log(e)
    if (e.detail.errMsg == "getUserInfo:ok") {
      app.globalData.userInfo = e.detail.userInfo

      this.setData({
        userInfo: e.detail.userInfo,
        hasLogin: true
      })
      

    } else {
      wx.showToast({
        title: "获取用户基本信息授权失败",
      })
    }
  },

sync: function() {
  if (app.globalData.userInfo != null) {
    this.setData({
      hasLogin: true
    })
  } else {
    this.setData({
      hasLogin: false
    })
  }

  this.setData({
    phoneNumber: app.globalData.phoneNumber
  })

},

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.sync();
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
  
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
  
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  }
})