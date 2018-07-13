var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    info: null
  },
loadConsultant: function(id) {
  var _ = this;

  wx.request({
    url: app.globalData.server + "consultant/get/" + id,
    success: function (res) {
      if (res.data.status == 200) {
        var info = res.data.data
        info.profile = app.globalData.server + info.profile
        
        _.setData({
          info: info
        })
        
      } else {
        wx.showToast({
          title: "加载咨询师数据失败！" + res.data.status,
          icon: "none"
        })
      }
    },
    fail: function(e) {
      console.log(e)
      wx.showToast({
        title: "加载咨询师数据失败！",
        icon: "none"
      })
    }
  })
},

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.loadConsultant(options.id);
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