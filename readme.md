<p align="center">
  <img src="app/src/main/res/mipmap-hdpi/icon.png" alt="哔哩终端" width="128" height="128">
</p>

<h1 align="center">哔哩终端 / BiliTerminal</h1>

<p align="center">
  <em>轻量的第三方 Bilibili 客户端（第三方维护分支）</em>
</p>

<p align="center">
  <a href="https://github.com/RobinNotBad/BiliClient">
    <img src="https://img.shields.io/badge/Android-4.0%2B-brightgreen" alt="Android 4.0+">
  </a>
  <img src="https://img.shields.io/badge/license-GPL--3.0-blue" alt="License">
  <img src="https://img.shields.io/badge/version-1.0.2--1-orange" alt="Version">
</p>

## 简介

**哔哩终端** 是一款专为低配置安卓手表与老旧手机设计的轻量级 Bilibili 第三方客户端。最低兼容 Android 4.0（API 14），致力于让更多设备能够流畅使用 B 站的基本功能。

本仓库为**第三方维护分支**，基于 [RobinNotBad](https://github.com/RobinNotBad/) 的原版 [BiliClient](https://github.com/RobinNotBad/BiliClient) 进行维护和更新。原版已由原作者宣布停更。

本软件基于 B 站网页端接口运行，不会对任何接口进行恶意请求，也不会收集任何用户隐私信息。代码完全开源，无付费功能。

> 愿你在这一方小小的屏幕中，找到属于自己的小小的快乐。

## 功能特性

### 核心功能
- **视频播放** — 支持内置 IJKPlayer 播放器与外部播放器，支持弹幕（Danmaku）、播放历史续播、清晰度选择
- **直播** — 直播房间浏览、关注直播列表、直播推荐
- **动态** — 浏览关注用户的动态（图文、视频、转发等），支持点赞、转发、删除
- **文章** — 图文内容（Opus）浏览，支持图片查看
- **评论系统** — 视频/动态/文章评论查看与回复

### 内容发现
- **搜索** — 全局搜索，支持视频、用户、番剧等
- **排行榜** — 全站排行榜
- **番剧影视时间线**
- **相关视频推荐**

### 用户相关
- **用户主页** — 查看用户信息、投稿、动态
- **消息通知** — 点赞、评论、关注等消息
- **私信** — 基础私信功能
- **收藏夹管理** — 视频收藏与整理
- **创作中心** — 查看投稿视频的数据变化
- **关注管理** — 关注/取关操作

### 界面与体验
- **可自定义 UI** — 字体缩放、界面边距、圆屏适配、横屏模式
- **表情系统** — 支持 B 站原生表情
- **图片查看器** — 支持多图浏览
- **下载管理** — 视频缓存与图片下载
- **媒体会话** — 支持通知栏与锁屏控制（部分设备）
- **多播放器支持** — 内置 IJKPlayer、小电视播放器、A liang Player

## 截图

<!-- 可在此处添加截图 -->

## 安装

1. 从 [Releases](BiliClient/releases) 下载最新 APK
2. 在设备上安装（可能需要开启"未知来源"安装权限）
3. 打开应用，按照引导完成初始设置

> 最低要求：Android 4.0（API 14）

## 构建

```bash
git clone https://github.com/RobinNotBad/BiliClient.git
cd BiliClient
./gradlew assembleDebug
```

APK 将生成在 `app/build/outputs/apk/debug/` 目录下。

### 构建注意事项
- 编译 SDK：33
- 目标 SDK：26
- 最低 SDK：14
- 使用 Java 8 编译

## 技术栈

| 类别 | 技术 |
|------|------|
| 语言 | Java |
| 网络 | OkHttp |
| 图片加载 | Glide |
| 图片查看 | PhotoView |
| HTML 解析 | Jsoup |
| 事件总线 | EventBus |
| 视频播放 | IJKPlayer |
| 弹幕 | DanmakuFlameMaster |
| 验证码 | Geetest |

## 开源协议

- **代码部分**：遵循 [GNU General Public License v3.0](https://www.gnu.org/licenses/gpl-3.0.html) 协议
- **布局（UI）部分**：遵循 [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/) 协议

## 致谢

本程序使用或借鉴了以下开源项目的部分代码及其合法收集的 API：

- [WearBili](https://github.com/SpaceXC/WearBili) — 旧版页面布局参考
- [腕上哔哩](https://github.com/luern0313/WristBilibili)
- [BAC Document](https://socialsisteryi.github.io/bilibili-API-collect) — B 站 API 文档
- [小电视播放器](https://github.com/xinxiangshiicheng/xinxiangshicheng_wearbili_player)
- 界面设计：[JesseGary\_](https://space.bilibili.com/17792828)（已获授权）
- 软件图标：[银狐enlab](https://space.bilibili.com/3461564301767781)（原图来自 B 站）

### 使用的第三方库

- OkHttp — `com.squareup.okhttp3:okhttp`
- Glide — `com.github.bumptech.glide:glide`
- PhotoView — `com.github.chrisbanes:PhotoView`
- Jsoup — `org.jsoup:jsoup`
- EventBus — `org.greenrobot:eventbus`
- IJKPlayer — `https://github.com/bilibili/ijkplayer`
- DanmakuFlameMaster — `com.github.ctiao:DanmakuFlameMaster`

## 免责声明

1. 本软件完全免费开源，不会收集任何用户的账号及隐私信息
2. 本软件基于 B 站网页端接口运行，不会对任何接口进行恶意请求
3. 本软件无付费功能，收到的捐赠仅用于服务器日常维护
4. 若你在任何平台付费下载到哔哩终端，说明你被坑了
5. 本软件不对学生用户在不当时间、地点使用导致的后果负责

## 链接

- **官网**：[bili.cxdqq.top](https://bili.cxdqq.top)
- **原版仓库（RobinNotBad）**：[https://github.com/RobinNotBad/BiliClient](https://github.com/RobinNotBad/BiliClient)
- **Gitee 镜像**：[https://gitee.com/RobinNotBad/BiliClient](https://gitee.com/RobinNotBad/BiliClient)
