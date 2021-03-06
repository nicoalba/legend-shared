// Copyright 2020 Goldman Sachs
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.finos.legend.server.pac4j.kerberos;

import javax.security.auth.Subject;
import org.ietf.jgss.GSSContext;

public class KerberosProfile extends org.pac4j.kerberos.profile.KerberosProfile
{
  private Subject subject;

  public KerberosProfile(Subject subject, final GSSContext gssContext)
  {
    super(gssContext);
    this.subject = subject;
  }

  public KerberosProfile(LocalCredentials creds)
  {
    setId(creds.getUserId());
    this.subject = creds.getSubject();
  }

  public KerberosProfile()
  {
  }

  public Subject getSubject()
  {
    return subject;
  }
}
