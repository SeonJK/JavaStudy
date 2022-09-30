# Android 4대 구성요소
안드로이드 애플리케이션은 독립적인 다양한 실행 단위를 하나로 묶어 관리하는 개념이다.
1. Activity
2. Service
3. Content Provider
4. Broadcast Receive

# Activity
## 개념
- 현재 보이는 화면을 관리하는 실행 단위
- 애플리케이션을 실행하면 액티비티가 실행되고 액티비티가 관리하는 화면이 나타나게 된다.

## 생명주기

<img height="80%" src="https://developer.android.com/guide/components/images/activity_lifecycle.png?hl=ko" width="90%"/></img>

### >생성순서
1. onCreate() : 액티비티가 생성될 때 호출되는 메서드
2. onStart() 
3. onResume()

### >소멸순서
1. onPause()
2. onStop()
3. onDestroy()

<br/>

# Intent
## 개념
- 안드로이드의 4대 구성요소를 실행하기 위해서 필요한 객체
- 실행하고자 하는 4대 구성요소와 관련된 정보를 가지고 있다.
- 개발자는 intent를 안드로이드 OS에 전달하고 안드로이드 OS에 의해 해당 구성요소가 실행된다.

## 동작방식
<img src="스크린샷 2022-09-23 오후 9.49.36.png"/> </img>

## Back Stack
액티비티가 실행되면 이전 액티비티는 Back Stack에 담겨 정지 상태가 된다.

## 액티비티 실행
- startActivity() : 인텐트에 저장된 액티비티 실행
- finish() : 액티비티 종

<br/>

# registerForActivityResult
액티비티가 다른 액티비티로 이동했다가 다시 돌아왔을 때 혹은 권한을 관리할 때 호출되는 메소드

## 콜백 등록
``` kotlin
// 콜백 등록
val resultActivityLauncher = registerForActivityResult(
    ActivityResultContracts.StartActivityForResult()
    ) { result ->
        when (result.resultCode) {
            RESULT_OK -> { // do something... }
        }
    }

// 액티비티 이동
val intent = Intent(...)
resultActivityLauncher.launch(intent)
```

