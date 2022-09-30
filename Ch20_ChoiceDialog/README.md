# 단일 선택 다이얼로그

- 라디오 버튼 형태를 제공하는 다이얼로그
- AlertDialog의 setSingleChoiceItem()을 통해 구현
- AlertDialog에서 ListView를 추출하고, ListView의 checkedItemPosition 프로퍼티를 이용해 선택한 항목의 인덱스 번호를 사용할 수 있다.

# 다중 선택 다이얼로그

- 라이도 버튼 형태를 제공하는 다이얼로그
- AlertDialog의 setMultiChoiceItems()를 통해 구현
- AlertDialog에서 ListView를 추출하고, ListView의 checkedItemPositions 프로퍼티를 이용해 선택한 항목의 인덱스 번호를 사용할 수 있다.
- 이때 선택 상태가 변경된 항목의 인덱스가 추출되므로 이를 이용해 선택 여부를 직접 확인하여야 한다.