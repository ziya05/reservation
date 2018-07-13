var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    ifGetUserInfo: false,
    introItems: [],
    consultantItems: []
  },

  login: function() {
    wx.navigateTo({
      url: "../user/user",
    })
  },

loadIntro: function() {
  var _ = this;

  wx.request({
    url: app.globalData.server + "intro/all",
    success: function(res) {
      if (res.data.status == 200) {
        var items = res.data.data

        for (var i = 0; i < items.length; i++) {
          var item = items[i]
          item.img = app.globalData.server + item.img
        }

        _.setData({
          introItems: res.data.data
        })
      } else {
        wx.showToast({
          title: "加载简介数据失败！" + res.data.status,
          icon: "none"
        })
      }
    }, 
    fail: function(e) {
      console.log(e)
      wx.showToast({
        title: "加载简介数据失败！",
        icon: "none"
      })
    }
  })
},

loadConsultant:function(){
  var _ = this;

  wx.request({
    url: app.globalData.server + "consultant/all",
    success: function (res) {
      if (res.data.status === 200) {
        var items = res.data.data

        for (var i = 0; i < items.length; i++) {
          var item = items[i]
          item.profile = app.globalData.server + item.profile

          item.status = "booked-status-" + item.booked         
        }

        _.setData({
          consultantItems: res.data.data
        })
      } else {
        wx.showToast({
          title: "加载咨询师列表数据失败！" + res.data.status,
          icon: "none"
        })
      }
    },
    fail: function (e) {
      console.log(e)
      wx.showToast({
        title: "加载咨询师列表数据失败！",
        icon: "none"
      })
    }
  })
},
  showConsultant:function(e) {
    var id = e.currentTarget.dataset.id;
    wx.navigateTo({
      url: '../consultant/consultant?id=' + id
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    if (app.globalData.userInfo != null) {
      this.setData({
        ifGetUserInfo:true
      })
    }

    this.loadIntro();
    this.loadConsultant();
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