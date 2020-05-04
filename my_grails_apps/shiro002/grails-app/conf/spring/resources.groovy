// Place your Spring DSL code here
import org.apache.shiro.authc.credential.Sha512CredentialsMatcher

beans = {
    credentialMatcher(Sha512CredentialsMatcher) {
        storedCredentialsHexEncoded = true
    }
}

