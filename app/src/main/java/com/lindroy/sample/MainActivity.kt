package com.lindroy.sample

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.lindroy.sample.constants.STATUS_NEED_LOGIN
import com.lindroy.sample.constants.STATUS_NO_COUPON
import kotlinx.android.synthetic.main.activity_main.*


private const val MENU_CONTENT = 100
private const val MENU_LOADING = 200
private const val MENU_EMPTY = 300
private const val MENU_ERROR = 400
private const val MENU_NO_NETWORK = 500
private const val MENU_NEED_LOGIN = 600
private const val MENU_NO_COUPON = 700
const val TAG = "MoreStatus"
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        statusView.setOnViewsClickListener {status,view->
            when (view.id) {
                R.id.btnError -> Toast.makeText(this, "点击重试", Toast.LENGTH_LONG).show()
                R.id.btnNoNetwork -> Toast.makeText(this, "点击重试", Toast.LENGTH_LONG).show()
                R.id.btnLogin-> Toast.makeText(this, "点击登录", Toast.LENGTH_LONG).show()
            }
        }

        statusView.setOnViewStatusChangeListener { oldStatus, newStatus ->
            Log.d(TAG,"oldStatus=$oldStatus,newStatus=$newStatus")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menu.add(0, MENU_CONTENT, 1, "内容视图")
        menu.add(0, MENU_LOADING, 1, "加载中视图")
        menu.add(0, MENU_EMPTY, 1, "空数据视图")
        menu.add(0, MENU_ERROR, 1, "错误视图")
        menu.add(0, MENU_NO_NETWORK, 1, "网络断开视图")
        menu.add(0, MENU_NEED_LOGIN, 1, "需要登录视图")
        menu.add(0, MENU_NO_COUPON, 1, "没有优惠券视图")
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            MENU_CONTENT -> Log.e("Tag", "内容视图")
            MENU_LOADING -> statusView.showLoading()
            MENU_EMPTY -> statusView.showEmpty()
            MENU_ERROR -> statusView.showError()
            MENU_NO_NETWORK -> statusView.showNoNetwork()
            MENU_NEED_LOGIN-> statusView.showStatusView(STATUS_NEED_LOGIN)
            MENU_NO_COUPON-> statusView.showStatusView(STATUS_NO_COUPON)

        }
        return super.onOptionsItemSelected(item)
    }
}
