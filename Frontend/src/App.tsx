import React from 'react';
import { Redirect, Route, Switch, useHistory } from 'react-router-dom';
import './App.css';

import { Auth0Provider, withAuthenticationRequired } from '@auth0/auth0-react';
import { auth0Config } from './lib/auth0Config';
import LoginPage from './Auth/LoginPage';
import { HomePage } from './layout/HomePage/HomePage';
import { Navbar } from './layout/NavbarAndFooter/Navbar';

import { Footer } from './layout/NavbarAndFooter/Footer';

const Auth0ProviderWithHistory = ({ children }: { children: React.ReactNode }) => {
  const history = useHistory();

  const onRedirectCallback = (appState: any) => {
    history.push(appState?.returnTo || "/home");
  };

  return (
    <Auth0Provider
      domain={auth0Config.issuer}
      clientId={auth0Config.clientId}
      authorizationParams={{
        redirect_uri: auth0Config.redirectUri,
        audience: auth0Config.audience,
        scope: auth0Config.scope,
      }} 
       onRedirectCallback={onRedirectCallback}
    >
      {children}
    </Auth0Provider>
  );
};

const SecureRoute = ({ component, path, ...args }: { component: React.ComponentType<any>, path: string }) => (
  <Route path={path} component={withAuthenticationRequired(component)} {...args} />
);



export const App = () => {

 

  return (
    <div className='d-flex flex-column min-vh-100'>
      <Auth0ProviderWithHistory>
      <Navbar />
      <div className='flex-grow-1'>
        <Switch>
          <Route path='/' exact>
            <Redirect to='/home' />
          </Route>
          <Route path='/home'>
            <HomePage />
          </Route>
          {/* <Route path='/search'>
            <SearchEquipmentsPage />
          </Route> */}
          {/* <Route path='/reviewlist/:bookId'>
            <ReviewListPage/>
          </Route>
          <Route path='/checkout/:bookId'>
            <BookCheckoutPage/>
          </Route> */}
  
          <Route path='/login' render={() => <LoginPage />} />
          {/* <SecureRoute path='/shelf' component={ShelfPage} />
          <SecureRoute path='/messages' component={MessagesPage} />
          <SecureRoute path='/admin' component={ManageLibraryPage} /> */}

        </Switch>
      </div>
      <Footer />
      </Auth0ProviderWithHistory>
    </div>
  );
}
