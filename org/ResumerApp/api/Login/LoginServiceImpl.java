package org.ResumerApp.api.Login;


import org.ResumerApp.api.Register.RegisterEntity;
import org.ResumerApp.api.Register.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private RegisterRepository registerRepository;

	@Autowired
	private LoginRepository loginRepository;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public String Login(RegisterEntity registerEntity) {
		if(registerRepository.findByEmail(registerEntity.getEmail())!=null)
		{
			if(passwordEncoder.matches(registerEntity.getPassword(), registerRepository.findByEmail(registerEntity.getEmail()).getPassword()))
			{
				return "Login Successful";
			}
			else {
				return "Incorrect Password";
			}
		}
		else 
		{
			return "Email is not registered";
		}
	}	
}
