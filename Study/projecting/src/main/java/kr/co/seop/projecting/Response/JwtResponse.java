package kr.co.seop.projecting.Response;

public class JwtResponse extends ApiResponse<String> {
    public JwtResponse(String token){
        super(token);
    }
}
