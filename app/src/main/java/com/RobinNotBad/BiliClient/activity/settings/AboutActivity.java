package com.RobinNotBad.BiliClient.activity.settings;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.RobinNotBad.BiliClient.R;
import com.RobinNotBad.BiliClient.activity.base.BaseActivity;
import com.RobinNotBad.BiliClient.activity.user.info.UserInfoActivity;
import com.RobinNotBad.BiliClient.util.GlideUtil;
import com.RobinNotBad.BiliClient.util.MsgUtil;
import com.RobinNotBad.BiliClient.util.SharedPreferencesUtil;
import com.RobinNotBad.BiliClient.util.StringUtil;
import com.RobinNotBad.BiliClient.util.ToolsUtil;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.card.MaterialCardView;

public class AboutActivity extends BaseActivity {
    int eggClick_authorWords = 0, eggClick_toUncle = 0, eggClick_Dev = 0;

    @SuppressLint({"MissingInflatedId", "SetTextI18n", "InflateParams"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        asyncInflate(R.layout.activity_setting_about, (layoutView, resId) -> {
            Log.e("debug", "进入关于页面");

            try {
                SpannableString version_str = new SpannableString("版本名\n" + getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
                version_str.setSpan(new StyleSpan(Typeface.BOLD), 0, 3, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
                ((TextView) findViewById(R.id.app_version)).setText(version_str);

                SpannableString code_str = new SpannableString("版本号\n" + getPackageManager().getPackageInfo(getPackageName(), 0).versionCode);
                code_str.setSpan(new StyleSpan(Typeface.BOLD), 0, 3, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
                ((TextView) findViewById(R.id.app_version_code)).setText(code_str);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }

            ImageView robinAvatar = findViewById(R.id.robinAvatar);
            try {
                Glide.with(this).load(R.mipmap.avatar_cxdqq)
                        .transition(GlideUtil.getTransitionOptions())
                        .placeholder(R.mipmap.akari)
                        .apply(RequestOptions.circleCropTransform())
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .into(robinAvatar);
            } catch (Exception ignored) {
            }

            MaterialCardView robinCard = findViewById(R.id.robin_card);
            robinCard.setOnClickListener(view -> {
                Intent intent = new Intent()
                        .setClass(this, UserInfoActivity.class)
                        .putExtra("mid", 3546772104284692L);
                startActivity(intent);
            });

            findViewById(R.id.author_words).setOnClickListener(view -> {
                eggClick_authorWords++;
                if (eggClick_authorWords == 7) {
                    eggClick_authorWords = 0;
                    MsgUtil.showText("作者的话", getString(R.string.egg_about_author_words));
                }
            });

            findViewById(R.id.toUncle).setOnClickListener(view -> {
                eggClick_toUncle++;
                if (eggClick_toUncle == 7) {
                    eggClick_toUncle = 0;
                    MsgUtil.showText("给叔叔", getString(R.string.egg_about_to_uncle));
                }
            });

            findViewById(R.id.icon_license_list).setOnClickListener(v -> {
                StringBuilder str = new StringBuilder(getString(R.string.desc_icon_license));

                String[] logItems = getResources().getStringArray(R.array.icon_license);
                for (int i = 0; i < logItems.length; i++)
                    str.append('\n').append((i + 1)).append('.').append(logItems[i]);
                MsgUtil.showText("开源图标的信息", str.toString());
            });

            if (!ToolsUtil.isDebugBuild()) findViewById(R.id.debug_tip).setVisibility(View.GONE);
            findViewById(R.id.version_code_card).setOnClickListener(view -> {
                if (SharedPreferencesUtil.getBoolean("developer", false)) {
                    MsgUtil.showMsg("已关闭开发者模式！");
                    SharedPreferencesUtil.putBoolean("developer", false);
                } else {
                    eggClick_Dev++;
                    if (eggClick_Dev == 7) {
                        SharedPreferencesUtil.putBoolean("developer", true);
                        MsgUtil.showMsg("已启用开发者模式！");
                        eggClick_Dev = 0;
                    }
                }
            });

            View scrollView = findViewById(R.id.scrollView);
            scrollView.setFocusable(true);
            scrollView.setFocusableInTouchMode(true);
            scrollView.requestFocus();
        });

    }
}
