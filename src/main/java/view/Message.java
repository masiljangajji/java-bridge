package view;

public enum Message {

    START_GAME("다리 건너기 게임을 시작합니다."),
    BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    BRIDGE_MOVING("다리의 길이를 입력해주세요."),
    SELECT_MOVING("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RE_START("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q"),
    GAME_RESULT("최종 게임 결과"),
    GAME_SUCCESS("게임 성공 여부:"),
    TOTAL_TRY("총 시도한 횟수: "),
    SUCCESS("성공"),
    FAIL("실패");


    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
