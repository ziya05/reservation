
var app = getApp()

Page({

  /**
   * 页面的初始数据
   */
  data: {
    items: null,
    selected: null
  },
  bindChange: function (e) {
    console.log(e)
    const val = e.detail.value
    
    var item = this.data.items[val[0]]
    this.setData({
      selected:item
    })
  },
  loadActived: function() {
    var _ = this;

    wx.request({
      url: app.globalData.server + "infor/actived",
      success: function (res) {
        if (res.data.status == 200) {
          var items = res.data.data

          for (var i = 0; i < items.length; i++) {
            var item = items[i]
            item.profile = app.globalData.server + item.profile
          }

          _.setData({
            items: items
          })

        } else {
          wx.showToast({
            title: "加载可预约数据失败！" + res.data.status,
            icon: "none"
          })
        }
      },
      fail: function (e) {
        console.log(e)
        wx.showToast({
          title: "加载可预约数据失败！",
          icon: "none"
        })
      }
    })
  },
  getPhoneNumber:function(e) {
    console.log(e.detail.errMsg)
    console.log(e.detail.iv)
    console.log(e.detail.encryptedData)
    if (e.detail.errMsg == 'getPhoneNumber:fail user deny') {
      wx.showModal({
        title: '提示',
        showCancel: false,
        content: '未授权',
        success: function (res) { }
      })
    } else {
      wx.showModal({
        title: '提示',
        showCancel: false,
        content: '同意授权',
        success: function (res) { }
      })
    }  
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.loadActived();
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