nthu-voip-web
===
點點通系列服務:

包含 點點通Web App 、多點通Web App、 離線通Web App
Directory structure
===
- ConCall	--- 多點通Web App 
- Mapping	--- 離線通Web App
- VoipProject --- 點點通 Web App


Environment
===
1. Java 1.8
2. Tomcat >= 7.0
3. eclipse for Java EE

Development
===
1. Open eclipse 
2. Navigate to `File > Import > Existing projects into workspace` and click `next`
3. Select "Select root directory" and click "Browse" button to find your project root location.
4. In projects, click all radio button to import all sub project
5. After import, you need to assoicate a Tomcat Server with your projects in eclipse.
6. You need to set Environment Variable `ROOT_BASE_URL`, `BASE_URL` and `API_KEY`, please consult this project manager to get these value.

Deployment
===
1. Set Environment Variable `ROOT_BASE_URL`, `BASE_URL` and `API_KEY` on a server.
2. Install a tomcat server
3. Export war files from ConCall, Mapping and  VoipProject.
4. Upload these war files to the tomcat server and restart the tomcat server
