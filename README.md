# Smile

## 简介
这是一个安卓项目架构的示例工程。项目的业务逻辑是按照一个社交类产品设计的，包含了例如登录、注册、发表动态等功能。

## 架构设计
整体架构的思路是按照Uncle Bob的[Clean Architecture](https://8thlight.com/blog/uncle-bob/2012/08/13/the-clean-architecture.html)来设计，将代码分为三层：界面层、业务逻辑层和数据层。界面层负责展示数据，响应用户操作并调用对应的业务逻辑；业务逻辑层封装了产品所有的业务逻辑并负责调用数据层进行具体的数据操作；数据层负责所有数据的存取，包括从后台和本地数据库中获取数据。
项目代码分为了三个模块：app-presentation、app-domain、app-data，分别对应界面层、业务层和数据层。

**该设计是以下列两个项目为原型：**

1. google的android-architecture项目中的[todo-mvp-clean](https://github.com/googlesamples/android-architecture/tree/todo-mvp-clean)分支
2. Fernando Cejas的[Android-CleanArchitecture](https://github.com/android10/Android-CleanArchitecture)

### 界面层（app-presentation）
负责实现所有界面相关的代码。通过UseCase与业务逻辑层进行交互，将获取到的数据进行展示或是将用户操作反馈给业务逻辑层，例如通过GetUserUseCase来获取用户信息，然后渲染到Activity中，通过UploadUserAvatarUserCase将用户从相册中选中的头像图片上传到服务器。
采用了MVP模式来分割代码，View专注于所有界面逻辑，Presenter负责处理View的反馈和调用UseCase，Model负责装载数据。

### 业务逻辑层（app-domain）
负责封装业务逻辑代码，将业务逻辑拆分为不同的UseCase。定义了Repository的接口，包含各种操作数据的方法，但不提供具体实现。UseCase可以调用Repository来完成具体的任务，例如LoginUserCase调用UserRepository.Login()方法实现用户的登录。

### 数据层（app-data）
负责实现具体的数据操作逻辑，提供了Repository的实现。数据层的Repository实现类负责管理用到的DataSource类。DataSource类封装了从不同的数据来源存取数据的方法，例如UserCloudDataSource是向云端存取User数据的类，UserLocalDataSource是在本地存取User数据的类。这些DataSource类负责调用NetworkService或是DAO来完成具体的数据操作，例如UserCloudDataSource会调用UserCloudService是进行网络请求，UserLocalDataSource会调用UserDao来操作本地数据库。

![Smile_Uml](zxjzerg.github.io/images/smile_class_uml.png)

