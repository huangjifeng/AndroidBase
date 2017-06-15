package com.huangjifeng.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RemoteViews;

/**
 * Notification
 * <p>
 * 一、使用步骤
 * 1、获取状态通知栏管理
 * 2、实例化通知栏构造器
 * 3、设置NotificationCompat.Builder（3.0以下的兼容包）或者Notification.Builder
 * 4、设置PendingIntent
 * 5、显示
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * http://blog.csdn.net/dsc114/article/details/51721472
 */

public class MainActivity extends AppCompatActivity {

    private NotificationManager manager;
    private boolean isNotify = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取状态通知栏管理
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_01:
                postNotification();
                isNotify = !isNotify;
                break;
            case R.id.button_02:
                postDownloadNotification();
                break;
            case R.id.button_03:
                postBigTextNotification();
                break;
            case R.id.button_04:
                postBigPictureNotification();
                break;
            case R.id.button_05:
                postCustomNotification();
                break;
        }
    }

    private void postNotification() {
        if (isNotify) {
            //需要跳转指定的页面，第一个参数只是需要上下文
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            //设置PendingIntent
            PendingIntent pendingIntent = PendingIntent
                    .getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            Notification.Builder builder = new Notification.Builder(this);
            //设置通知栏点击意图
            builder.setContentIntent(pendingIntent);
            //设置图标
            builder.setSmallIcon(R.mipmap.ic_launcher);
            //设置通知的标题
            builder.setContentTitle("这是一个标题");
            //设置该通知优先级
            builder.setPriority(Notification.PRIORITY_DEFAULT);
            //设置通知的显示内容
            builder.setContentText("这真的是全部的内容  了 --------");
            // 通知时间，一般为系统时间，也可以使用setWhen()设置。发送此通知的时间戳
            builder.setWhen(System.currentTimeMillis());
            //设置这个标志当用户单击面板就可以让通知将自动取消
            builder.setAutoCancel(true);
            //通知首次出现在通知栏，带上升动画效果的,就是或5.0之后只有开启扶住功能后Ticker才有用
            builder.setTicker("new Message");
            /**
             * ture，设置他为一个正在进行的通知。他们通常是用来表示一个后台任务,用户积极参与
             * (如播放音乐)或以某种方式正在等待,因此占用设备(如一个文件下载,同步操作,主动网络连接)
             * 比如，在下载的时候就可以设置为true，当下载完成之后就设置为false
             * */
            builder.setOngoing(true);
            //设置通知集合的数量
            builder.setNumber(20);
            Notification notification = builder.build();
            /**
             * DEFAULT_ALL    使用所有默认值，比如声音，震动，闪屏等等
             * DEFAULT_LIGHTS 使用默认闪光提示
             * DEFAULT_SOUNDS 使用默认提示声音
             * DEFAULT_VIBRATE 使用默认手机震动
             * <uses-permission android:name="android.permission.VIBRATE"/>
             * */
            notification.defaults = Notification.DEFAULT_ALL;
            /**
             * FLAG_AUTO_CANCEL  该通知能被状态栏的清除按钮给清除掉，同时也能被左右滑动取消
             * FLAG_NO_CLEAR     该通知不能被状态栏的清除按钮给清除掉，同时也不能被滑动取消
             * FLAG_ONGOING_EVENT 通知放置在正在运行，还不确定怎么用
             * FLAG_INSISTENT 是否一直进行，比如音乐一直播放，知道用户响应
             * */
            notification.flags = Notification.FLAG_ONLY_ALERT_ONCE;
            /**
             * 将通知加入状态栏，标记为id，使用与之前通知相同标识符来发送通知，
             * 这个时候旧的通知就被被新的通知所取代，起到更新通知的效果.
             */
            manager.notify(0, notification);
        } else {
            manager.cancel(0);
        }

    }

    /**
     * 使用下载的Notification,在4.0以后才能使用
     * Notification.Builder类中提供一个setProgress(int max,int progress,boolean indeterminate)方法用于设置进度条，
     * max用于设定进度的最大数，progress用于设定当前的进度，indeterminate用于设定是否是一个确定进度的进度条。
     * 通过indeterminate的设置，可以实现两种不同样式的进度条，一种是有进度刻度的（true）,一种是循环流动的（false）。
     */
    private void postDownloadNotification() {
        final Notification.Builder builder = new Notification.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setTicker("show ProgressBar")
                .setContentText("作曲：方文山--")
                .setOngoing(true)
                .setContentTitle("青花瓷")
                .setContentInfo("演唱者：周杰伦");
        new Thread(new Runnable() {
            @Override
            public void run() {
                int progress;
                for (progress = 0; progress < 100; progress += 5) {
                    builder.setProgress(100, progress, false);
                    manager.notify(0, builder.build());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                builder.setContentTitle("Download complete")
                        .setContentText("下载完成")
                        .setProgress(0, 0, false)
                        .setOngoing(false);
                manager.notify(10, builder.build());
            }
        }).start();

    }

    /**
     * 大视图通知在4.1以后才能使用
     */
    private void postBigTextNotification() {
        Notification.BigTextStyle textStyle = new Notification.BigTextStyle();
        textStyle.setBigContentTitle("-大标题-")
                .setSummaryText("SummaryText")
                .bigText("-----****-----------hahahaha ======sfeohdsgsdjfgasjsdoifj" +
                        "sdfjklwejfosi----------------89sjkkkkkkkkkkkkkkkkkkkkkkkkkk" +
                        "skldfjwieojfasjdfjwejfisdjfo---------------------------------");
        Notification.Builder builder = new Notification.Builder(this);
        builder.setSmallIcon(R.drawable.cai_not_clicked_black);
        builder.setLargeIcon(BitmapFactory.decodeResource(this.getResources(), R.mipmap.ic_launcher));
        builder.setTicker("showBigView_text")
                .setContentInfo("contentInfo");
        builder.setStyle(textStyle);
        builder.setAutoCancel(true);
        manager.notify(1, builder.build());

    }

    private void postBigPictureNotification() {
        Notification.BigPictureStyle pictureStyle = new Notification.BigPictureStyle();
        pictureStyle.bigPicture(BitmapFactory.decodeResource(this.getResources(), R.mipmap.ic_launcher));
        Notification.Builder builder = new Notification.Builder(this);
        builder.setSmallIcon(R.drawable.ding_not_clicked_black)
                .setLargeIcon(BitmapFactory.decodeResource(this.getResources(), R.mipmap.ic_launcher))
                .setTicker("showBigPicture")
                .setContentInfo("contentInfo")
                .setStyle(pictureStyle)
                .setAutoCancel(true);
        manager.notify(2, builder.build());
    }

    /**
     * 自定义通知<p></p>
     * <p>
     * 不设置notification.contentIntent = pendingIntent;则报如下异常：
     * android.app.RemoteServiceException:
     * Bad notification posted from package com.test.testandroid: Couldn't expand RemoteViews for: StatusBarNotification(
     * pkg=com.test.testandroid user=UserHandle{0} id=0 tag=null score=0 key=0|com.test.testandroid|0|null|10168|0: Notification
     * (pri=0 contentView=com.test.testandroid/0x7f040038 vibrate=null sound=null defaults=0x0 flags=0x10 color=0xff00aeff vis=PRIVATE))
     */
    private void postCustomNotification() {
        RemoteViews contentView = new RemoteViews(this.getPackageName(), R.layout.mynotification);
        contentView.setImageViewResource(R.id.left_picture, R.mipmap.ic_launcher);
        contentView.setTextViewText(R.id.title_text, "自定义的标题");
        contentView.setTextViewText(R.id.content_text, "自定义的通知内容");
        Intent intent = new Intent(this, SecondActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        contentView.setOnClickPendingIntent(R.id.title_text, pendingIntent);
        contentView.setOnClickPendingIntent(R.id.content_text, PendingIntent.getActivity(
                this, 2, new Intent(this, ThirdActivity.class), PendingIntent.FLAG_UPDATE_CURRENT
        ));

        Notification.Builder builder = new Notification.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("custom notification")
                .setContentText("custom text")
                .setAutoCancel(true)
                .setContent(contentView);
        manager.notify(7, builder.build());


    }


}
